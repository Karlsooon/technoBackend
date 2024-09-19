package techno.hub.backend.services;

import techno.hub.backend.dtos.TagDto;
import techno.hub.backend.dtos.TagResponse;
import techno.hub.backend.entities.Tag;

import java.util.List;

public interface TagService {
    List<TagResponse> findAll();
    TagResponse getTagById(long id);
    TagDto createTag(TagDto createTagDto);
    void deleteTag(long id);
    List<TagResponse> getAllTagsWithBlogs();

}
