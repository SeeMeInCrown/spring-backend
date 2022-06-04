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

    public List<Presentation> createPresentation() {
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
        try {
            ProcessBuilder pb = new ProcessBuilder("python",
                    "conference.py");
            Process p = pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("OPTIMIZATION IS DONE!");
        System.out.println("READING OPTIMIZATION RESULT IS STARTED!");
        //READ RESULTS

        CsvToBean csvReader = null;
        try {
            csvReader = new CsvToBeanBuilder(new FileReader("result.csv"))
                    .withType(PresentationDto.class)
                    //.withMappingStrategy(mappingStrategy)
                    .build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("READING OPTIMIZATION RESULT IS DONE!");

        List<PresentationDto> results = csvReader.parse();

        System.out.println(results);
        List<Presentation> lists = results
                .stream()
                .map(user -> modelMapper.map(user, Presentation.class))
                .collect(Collectors.toList());


        return presentationRepository.saveAll(lists);
    }

//    public Presentation updatePresentation(Long id, Presentation presentationRequest) {
//        Presentation presentation = presentationRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("No valid presentation!") );
//
//        presentation.setRoomNo(presentationRequest.getRoomNo());
//        presentation.setSessionNo(presentationRequest.getSessionNo());
//        presentation.setDayNo(presentationRequest.getDayNo());
//        presentation.setStart_time(presentationRequest.getStart_time());
//        presentation.setEnd_time(presentationRequest.getEnd_time());
//        presentation.setPresenter(presentationRequest.getPaper());
//        return presentationRepository.save(presentation);
//    }

    public Presentation getPresentationById(Long id) {
        Optional<Presentation> result = presentationRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new RuntimeException("No valid presentation!");
        }

    }

    public void deleteAllPresentations() {
        presentationRepository.deleteAll();
    }


}
