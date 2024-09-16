package techno.hub.backend.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import techno.hub.backend.dtos.TagDto;
import techno.hub.backend.entities.Tag;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-16T19:43:41+0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public Tag toEntity(TagDto dto) {
        if ( dto == null ) {
            return null;
        }

        Tag tag = new Tag();

        if ( dto.getId() != null ) {
            tag.setId( dto.getId() );
        }
        tag.setName( dto.getName() );

        return tag;
    }

    @Override
    public TagDto toDto(Tag entity) {
        if ( entity == null ) {
            return null;
        }

        TagDto tagDto = new TagDto();

        tagDto.setId( entity.getId() );
        tagDto.setName( entity.getName() );

        return tagDto;
    }

    @Override
    public List<Tag> toEntity(List<TagDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Tag> list = new ArrayList<Tag>( dtoList.size() );
        for ( TagDto tagDto : dtoList ) {
            list.add( toEntity( tagDto ) );
        }

        return list;
    }

    @Override
    public List<TagDto> toDTO(List<Tag> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TagDto> list = new ArrayList<TagDto>( entityList.size() );
        for ( Tag tag : entityList ) {
            list.add( toDto( tag ) );
        }

        return list;
    }
}
