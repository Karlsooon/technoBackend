package techno.hub.backend.controllers;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import techno.hub.backend.dtos.TagDto;
import techno.hub.backend.dtos.TagResponse;
import techno.hub.backend.entities.Tag;
import techno.hub.backend.services.TagService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tags")
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class TagController {

    private final TagService tagService;

    @GetMapping("/all")
    public ResponseEntity<List<TagResponse>> getAllTagsWithBlogs() {
        List<TagResponse> tags = tagService.getAllTagsWithBlogs();
        return ResponseEntity.ok(tags);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TagResponse> getTagById(@PathVariable long id) {
        log.info("Fetching tag with ID: {}", id);
        var result = tagService.getTagById(id);
        log.info("Result: {}", result);
        return ResponseEntity.ok(result);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<TagDto> createTag(@RequestBody TagDto tag) {
        var createdTag = tagService.createTag(tag);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTag);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteTag(@PathVariable long id) {
        tagService.deleteTag(id);
    }


}

