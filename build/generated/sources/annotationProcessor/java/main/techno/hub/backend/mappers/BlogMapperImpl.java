package techno.hub.backend.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import techno.hub.backend.dtos.BlogDto;
import techno.hub.backend.dtos.TagDto;
import techno.hub.backend.entities.Blog;
import techno.hub.backend.entities.Tag;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-16T19:43:41+0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class BlogMapperImpl implements BlogMapper {

    @Override
    public Blog toEntity(BlogDto dto) {
        if ( dto == null ) {
            return null;
        }

        Blog blog = new Blog();

        blog.setId( dto.getId() );
        blog.setTitle( dto.getTitle() );
        blog.setContent( dto.getContent() );
        blog.setCreatedAt( dto.getCreatedAt() );
        blog.setUpdatedAt( dto.getUpdatedAt() );
        blog.setTags( tagDtoListToTagList( dto.getTags() ) );
        blog.setImageUrl( dto.getImageUrl() );

        return blog;
    }

    @Override
    public BlogDto toDto(Blog entity) {
        if ( entity == null ) {
            return null;
        }

        BlogDto blogDto = new BlogDto();

        blogDto.setId( entity.getId() );
        blogDto.setTitle( entity.getTitle() );
        blogDto.setContent( entity.getContent() );
        blogDto.setCreatedAt( entity.getCreatedAt() );
        blogDto.setUpdatedAt( entity.getUpdatedAt() );
        blogDto.setTags( tagListToTagDtoList( entity.getTags() ) );
        blogDto.setImageUrl( entity.getImageUrl() );

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

    protected Tag tagDtoToTag(TagDto tagDto) {
        if ( tagDto == null ) {
            return null;
        }

        Tag tag = new Tag();

        if ( tagDto.getId() != null ) {
            tag.setId( tagDto.getId() );
        }
        tag.setName( tagDto.getName() );

        return tag;
    }

    protected List<Tag> tagDtoListToTagList(List<TagDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Tag> list1 = new ArrayList<Tag>( list.size() );
        for ( TagDto tagDto : list ) {
            list1.add( tagDtoToTag( tagDto ) );
        }

        return list1;
    }

    protected TagDto tagToTagDto(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        TagDto tagDto = new TagDto();

        tagDto.setId( tag.getId() );
        tagDto.setName( tag.getName() );

        return tagDto;
    }

    protected List<TagDto> tagListToTagDtoList(List<Tag> list) {
        if ( list == null ) {
            return null;
        }

        List<TagDto> list1 = new ArrayList<TagDto>( list.size() );
        for ( Tag tag : list ) {
            list1.add( tagToTagDto( tag ) );
        }

        return list1;
    }
}
