package org.catherine.accountabilitytracker.Controllers;
import lombok.extern.slf4j.Slf4j;
import org.catherine.accountabilitytracker.Entity.Goal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/accountability")
public class AccountabilityController {

    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    @PostMapping("/")
    public void addGoal(@RequestBody Goal goal){
    //log.info("goal is >>>{}", goal);
        log.info("Goal received: Name - {}, Target Date - {}", goal.name(), goal.targetDate());
        // Here you would typically save the goal to a database or perform some action with it
        // For now, we just log the goal details

    }
}
