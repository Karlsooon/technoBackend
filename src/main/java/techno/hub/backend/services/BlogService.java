package techno.hub.backend.services;

import org.springframework.web.multipart.MultipartFile;
import techno.hub.backend.dtos.BlogCreateRequestDto;
import techno.hub.backend.dtos.BlogDto;
import techno.hub.backend.dtos.BlogResponse;
import techno.hub.backend.entities.Blog;

import java.util.List;

public interface BlogService {
    List<BlogResponse> findAll();

    BlogResponse getBlogById(long id);


    BlogDto saveBlog(BlogCreateRequestDto blog, MultipartFile file);

    void deleteBlog(long id);

    void addTagsToBlog(Long id, List<Long> tagIds);

    List<BlogResponse> getBlogsByTagName(String tagName);

    void deleteTagFromBlog(long blogId, long tagId);
}
