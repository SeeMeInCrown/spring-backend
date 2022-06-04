package net.conferencescheduling.spring.service;

import net.conferencescheduling.spring.model.entity.Info;
import net.conferencescheduling.spring.repository.InfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    private final InfoRepository infoRepository;

    @Autowired
    public InfoService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public Info createInfo(Info info) {
        return infoRepository.save(info);
    }
    public List<Info> getAllInfo() {
        return infoRepository.findAll();
    }
    public void deleteAllInfo() {
        infoRepository.deleteAll();
    }

}
