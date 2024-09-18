package techno.hub.backend.mappers;

import techno.hub.backend.dtos.CreateTagDto;
import techno.hub.backend.dtos.TagDto;
import techno.hub.backend.entities.Tag;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TagMapper extends BaseMapper<Tag, TagDto> {
    default Tag toEntity(CreateTagDto createTagDto) {
        Tag tag = new Tag();
        tag.setName(createTagDto.getName());
        return tag;
    }
    List<TagDto> toDTO(List<Tag> entityList);
    TagDto toDto(Tag entity);


}
