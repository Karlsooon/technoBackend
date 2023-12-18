package techno.hub.backend.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import techno.hub.backend.dtos.BlogDto;
import techno.hub.backend.entities.Blog;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-18T19:24:39+0600",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class BlogMapperImpl implements BlogMapper {

    @Override
    public Blog toEntity(BlogDto dto) {
        if ( dto == null ) {
            return null;
        }

        Blog blog = new Blog();

        return blog;
    }

    @Override
    public BlogDto toDto(Blog entity) {
        if ( entity == null ) {
            return null;
        }

        BlogDto blogDto = new BlogDto();

        return blogDto;
    }

    @Override
    public List<Blog> toEntity(List<BlogDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Blog> list = new ArrayList<Blog>( dtoList.size() );
        for ( BlogDto blogDto : dtoList ) {
            list.add( toEntity( blogDto ) );
        }

        return list;
    }

    @Override
    public List<BlogDto> toDTO(List<Blog> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BlogDto> list = new ArrayList<BlogDto>( entityList.size() );
        for ( Blog blog : entityList ) {
            list.add( toDto( blog ) );
        }

        return list;
    }
}
