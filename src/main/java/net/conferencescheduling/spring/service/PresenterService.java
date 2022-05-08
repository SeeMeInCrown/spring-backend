package net.conferencescheduling.spring.service;

import net.conferencescheduling.spring.model.entity.Presenter;
import net.conferencescheduling.spring.repository.PresenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresenterService{

    private final PresenterRepository presenterRepository;

    @Autowired
    public PresenterService(PresenterRepository presenterRepository) {
        this.presenterRepository = presenterRepository;
    }

    public List<Presenter> getAllPresenters() {
        return presenterRepository.findAll();
    }

    public Presenter createPresenter(Presenter presenter) {
        return presenterRepository.save(presenter);
    }

    public Presenter updatePresenter(Long id, Presenter presenterRequest) {
        Presenter presenter = presenterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No valid presenter!") );

        presenter.setName(presenterRequest.getName());
        presenter.setSurname(presenterRequest.getSurname());
        return presenterRepository.save(presenter);
    }

    public Presenter getPresenterById(Long id) {
        Optional<Presenter> result = presenterRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new RuntimeException("No valid presenter!");
        }

    }

}
