package net.kiranatos.services;

import java.util.List;
import net.kiranatos.entities.FeedbackEntity;
import net.kiranatos.repositories.FeedbackRepository;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public void saveAll(List<FeedbackEntity> list) {
        feedbackRepository.saveAll(list);
    }

}
