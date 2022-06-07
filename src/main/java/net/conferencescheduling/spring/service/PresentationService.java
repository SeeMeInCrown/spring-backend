package net.conferencescheduling.spring.service;

import com.opencsv.bean.*;
import net.conferencescheduling.spring.model.dto.ConstraintDto;
import net.conferencescheduling.spring.model.dto.InfoDto;
import net.conferencescheduling.spring.model.dto.PaperDto;
import net.conferencescheduling.spring.model.dto.PresentationDto;
import net.conferencescheduling.spring.model.entity.Presentation;
import net.conferencescheduling.spring.repository.PresentationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PresentationService {

    private final PresentationRepository presentationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ConstraintService constraintService;

    @Autowired
    private PaperService paperService;

    @Autowired
    private InfoService infoService;

    @Autowired
    public PresentationService(PresentationRepository presentationRepository) {
        this.presentationRepository = presentationRepository;
    }

    public List<Presentation> getAllPresentations() {
        return presentationRepository.findAll();
    }

    public List<Presentation> createPresentation()  {
        final String csv_location = "constraints.csv";
        try {
            FileWriter writer = new
                    FileWriter(csv_location);
            List<ConstraintDto> constraints = constraintService.getAllConstraints();

            ColumnPositionMappingStrategy mappingStrategy =
                    new ColumnPositionMappingStrategy();
            mappingStrategy.setType(ConstraintDto.class);

//            String[] columns = new String[]
//                    {"dayNo", "parallelSessionCount","presentationDuration","sessionDuration",
//                            "sessionNo", "startTime", "endTime" };
//            mappingStrategy.setColumnMapping(columns);

            StatefulBeanToCsvBuilder<ConstraintDto> builder =
                    new StatefulBeanToCsvBuilder(writer);
            StatefulBeanToCsv beanWriter =
                    builder.withMappingStrategy(mappingStrategy).build();

            beanWriter.write(constraints);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //TODO CREATE PAPER CSV ------------------------------------------------------------------------

        final String papers_location = "papers.csv";
        try {
            FileWriter writer = new
                    FileWriter(papers_location);
            List<PaperDto> papers = paperService.getAllPapers().stream().map(paper -> modelMapper.map(paper, PaperDto.class)).toList();

            ColumnPositionMappingStrategy mapping =
                    new ColumnPositionMappingStrategy();
            mapping.setType(PaperDto.class);

            StatefulBeanToCsvBuilder<PaperDto> builder =
                    new StatefulBeanToCsvBuilder(writer);
            StatefulBeanToCsv beanWriter =
                    builder.build();

            beanWriter.write(papers);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //TODO CREATE INFO CSV ------------------------------------------------------------------------

        final String info_location = "info.csv";
        try {
            FileWriter writer = new
                    FileWriter(info_location);
            List<InfoDto> infos = infoService.getAllInfo().stream().map(info -> modelMapper.map(info, InfoDto.class)).toList();

            ColumnPositionMappingStrategy mapping =
                    new ColumnPositionMappingStrategy();
            mapping.setType(InfoDto.class);

            StatefulBeanToCsvBuilder<InfoDto> builder =
                    new StatefulBeanToCsvBuilder(writer);
            StatefulBeanToCsv beanWriter =
                    builder.build();

            beanWriter.write(infos);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("OPTIMIZATION IS INITIALIZED!");

        //CALL PYTHON
        while(true) {
            if (Files.exists(Path.of("papers.csv")) &&
                    Files.exists(Path.of("constraints.csv")) &&
                    Files.exists(Path.of("info.csv"))) {
                try {
                    ProcessBuilder pb = new ProcessBuilder("python",
                            "conference.py");
                    Process p = pb.start();
                    //Thread.sleep(180000);
                    //p.destroy();
                    break;

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


        System.out.println("OPTIMIZATION IS DONE!");
        System.out.println("READING OPTIMIZATION RESULT IS STARTED!");
        //READ RESULTS


        CsvToBean csvReader = null;
        FileReader reader = null;

        while(true){
            if(Files.exists(Path.of("result.csv"))){
                try {
                    reader = new FileReader("result.csv");

                 csvReader = new CsvToBeanBuilder(reader)
                           .withType(PresentationDto.class)
                            //.withMappingStrategy(mappingStrategy)
                          .build();

               } catch (FileNotFoundException e) {
                 e.printStackTrace();
               }

              break;
            }
         }

        System.out.println("READING OPTIMIZATION RESULT IS DONE!");


        List<PresentationDto> results = csvReader.parse();


        List<Presentation> lists = results
                .stream()
                .map(user -> modelMapper.map(user, Presentation.class))
                .collect(Collectors.toList());

        System.out.println(results);

        try {
            assert reader != null;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return presentationRepository.saveAll(lists);
    }



    public void deleteAllPresentations() {
        presentationRepository.deleteAll();

            if(Files.exists(Path.of("result.csv"))) {

                try {
                    Files.delete(Path.of("result.csv"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        if(Files.exists(Path.of("constraints.csv"))) {

            try {
                Files.delete(Path.of("constraints.csv"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(Files.exists(Path.of("info.csv"))) {

            try {
                Files.delete(Path.of("info.csv"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(Files.exists(Path.of("papers.csv"))) {

            try {
                Files.delete(Path.of("papers.csv"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
