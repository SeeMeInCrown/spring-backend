//package net.conferencescheduling.spring.service;
//
//import net.conferencescheduling.spring.repository.ConstraintRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class SessionService {
//
//    private final SessionRepository sessionRepository;
//
//    @Autowired
//    private ConstraintRepository constraintRepository;
//
//    @Autowired
//    public SessionService(SessionRepository sessionRepository) {
//        this.sessionRepository = sessionRepository;
//    }
//
//    public List<Session> getAllSessions() {
//        return sessionRepository.findAll();
//    }
//
//    public Session createSession(Session session) {
//        return sessionRepository.save(session);
//    }
//
//    public Session updateSession(Long id, Session sessionRequest) {
//        Session session = sessionRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("No valid session!") );
//
//        session.setSessionCount(sessionRequest.getSessionCount());
//        session.setSessionDuration(sessionRequest.getSessionDuration());
//        session.setConstraint(sessionRequest.getConstraint());
//        session.setSessionStartTime(sessionRequest.getSessionStartTime());
//        session.setSessionEndTime(sessionRequest.getSessionEndTime());
//        session.setParallelSessionCount(sessionRequest.getParallelSessionCount());
//        return sessionRepository.save(session);
//    }
//
//    public Session getSessionById(Long id) {
//        Optional<Session> result = sessionRepository.findById(id);
//        if(result.isPresent()) {
//            return result.get();
//        }else {
//            throw new RuntimeException("No valid session!");
//        }
//
//    }
//
//    public Session assignSessionToConstraint(Long sessionId, Long constraintId){
//        Session session=sessionRepository.getById(sessionId);
//        Constraint constraint=constraintRepository.getById(constraintId);
//        session.assignConstraint(constraint);
//        return sessionRepository.save(session);
//    }
//}
