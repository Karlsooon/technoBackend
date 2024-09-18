package techno.hub.backend.services;

import techno.hub.backend.dtos.TagDto;

import java.util.List;

public interface TagService {
    List<TagDto> findAll();
    TagDto getTagById(long id);
    TagDto createTag(TagDto createTagDto);
    void deleteTag(long id);
    List<TagDto> getAllTagsWithBlogs();

}
