package techno.hub.backend.mappers;

import techno.hub.backend.dtos.BlogDto;
import techno.hub.backend.entities.Blog;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface BlogMapper extends BaseMapper<Blog, BlogDto> {
    BlogDto toDto(Blog entity);
    List<BlogDto> toDTO(List<Blog> entityList);
}

