//package net.conferencescheduling.spring.service;
//
//import net.conferencescheduling.spring.model.entity.Keyword;
//import net.conferencescheduling.spring.repository.KeywordRepository;
//import net.conferencescheduling.spring.repository.PaperRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class KeywordService {
//
//    private final KeywordRepository keywordRepository;
//
//    @Autowired
//    private PaperRepository paperRepository;
//
//    @Autowired
//    public KeywordService(KeywordRepository keywordRepository) {
//        this.keywordRepository = keywordRepository;
//    }
//
//    public List<Keyword> getAllKeywords() {
//        return keywordRepository.findAll();
//    }
//
//    public Keyword createKeyword(Keyword keyword) {
//        return keywordRepository.save(keyword);
//    }
//
////    public Keyword updateRoom(Long id, Keyword keywordRequest) {
////        Keyword keyword = presentationRepository.findById(id)
////                .orElseThrow(() -> new RuntimeException("No valid room!") );
////
////        keyword.setRoomNo(keywordRequest.getRoomNo());
////        keyword.setRoomCount(keywordRequest.getRoomCount());
////        keyword.setConstraint(keywordRequest.getConstraint());
////        return presentationRepository.save(keyword);
////    }
//
//    public Keyword getKeywordById(Long id) {
//        Optional<Keyword> result = keywordRepository.findById(id);
//        if(result.isPresent()) {
//            return result.get();
//        }else {
//            throw new RuntimeException("No valid keyword!");
//        }
//
//    }
//
//}
