package net.conferencescheduling.spring.service;

import com.opencsv.CSVReader;
import com.opencsv.bean.*;
import net.conferencescheduling.spring.model.entity.ConstraintDto;
import net.conferencescheduling.spring.model.entity.Presentation;
import net.conferencescheduling.spring.repository.ConstraintRepository;
import net.conferencescheduling.spring.repository.PresentationRepository;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

@Service
public class PresentationService {

    private final PresentationRepository presentationRepository;

    @Autowired
    private ConstraintService constraintService;

    @Autowired
    public PresentationService(PresentationRepository presentationRepository) {
        this.presentationRepository = presentationRepository;
    }

    public List<Presentation> getAllPresentations() {
        final String csv_location = "presentation.csv";
        try {
            FileWriter writer = new
                    FileWriter(csv_location);
            List<ConstraintDto> constraints = constraintService.getAllConstraints();

            ColumnPositionMappingStrategy mappingStrategy =
                    new ColumnPositionMappingStrategy();
            mappingStrategy.setType(ConstraintDto.class);

            String[] columns = new String[]
                    {"dayNo", "parallelSessionCount", "sessionCount", "startTime",
                            "endTime", "sessionDuration", "presentationDuration", "papers"};
            mappingStrategy.setColumnMapping(columns);

            StatefulBeanToCsvBuilder<ConstraintDto> builder =
                    new StatefulBeanToCsvBuilder(writer);
            StatefulBeanToCsv beanWriter =
                    builder.withMappingStrategy(mappingStrategy).build();

            beanWriter.write(constraints);

            //TODO CALL PYTHON SCRIPT and write to new csv

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //TODO ------------------------------------------------------------------------

        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("presentation.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        CsvToBean csvReader = new CsvToBeanBuilder(reader)
                .withType(ConstraintDto.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .build();

        List<ConstraintDto> results = csvReader.parse();
        System.out.println(results);

        //TODO presentationRepository.saveAll(resultlist);

        return presentationRepository.findAll();
    }

    //sending contraints to python and get the results
    public Presentation createPresentation(Presentation presentation) {

        return presentationRepository.save(presentation);
    }

    public Presentation updatePresentation(Long id, Presentation presentationRequest) {
        Presentation presentation = presentationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No valid presentation!") );

        presentation.setRoomNo(presentationRequest.getRoomNo());
        presentation.setSessionNo(presentationRequest.getSessionNo());
        presentation.setDayNo(presentationRequest.getDayNo());
        presentation.setStart_time(presentationRequest.getStart_time());
        presentation.setEnd_time(presentationRequest.getEnd_time());
        presentation.setPaper(presentationRequest.getPaper());
        return presentationRepository.save(presentation);
    }

    public Presentation getPresentationById(Long id) {
        Optional<Presentation> result = presentationRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new RuntimeException("No valid presentation!");
        }

    }

}
