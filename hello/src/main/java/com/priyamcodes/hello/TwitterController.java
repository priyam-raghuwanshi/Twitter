
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import twitter4j.Status;

import java.util.List;

@RestController
@RequestMapping("/api/twitter")
public class TwitterController {
    @Autowired
    private TwitterService twitterService;

    // API 1: Search tweets by user
    @GetMapping("/search/{username}")
    public ResponseEntity<List<Status>> searchTweetsByUser(@PathVariable String username) throws TwitterException {
        List<Status> tweets = twitterService.searchTweetsByUser(username);
        return ResponseEntity.ok(tweets);
    }

    // API 2: Get tweets of the selected user
    @GetMapping("/tweets/{username}")
    public ResponseEntity<List<Status>> getTweetsOfUser(@PathVariable String username) throws TwitterException {
        List<Status> tweets = twitterService.getTweetsOfUser(username);
        return ResponseEntity.ok(tweets);
    }
}
