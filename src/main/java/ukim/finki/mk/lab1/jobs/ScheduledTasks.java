package ukim.finki.mk.lab1.jobs;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ukim.finki.mk.lab1.service.application.BookApplicationService;
import ukim.finki.mk.lab1.service.domain.BookService;

@Component
public class ScheduledTasks {
    private final BookService bookService;
    private final BookApplicationService bookApplicationService;

    public ScheduledTasks(BookService bookService, BookApplicationService bookApplicationService) {
        this.bookService = bookService;
        this.bookApplicationService = bookApplicationService;
    }

    @Scheduled(cron = "0 * * * * *")
    public void refreshMaterializedView() {
        this.bookApplicationService.refreshBooksByAuthorView();
    }

}