package techno.hub.backend.mappers;

import org.springframework.stereotype.Component;
import techno.hub.backend.dtos.BlogDto;
import techno.hub.backend.dtos.TagDto;
import techno.hub.backend.dtos.TagResponse;
import techno.hub.backend.entities.Blog;
import techno.hub.backend.entities.Tag;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TagMapper {


        // Convert Tag to TagDto
        public TagDto toDto(Tag tag) {
            if (tag == null) {
                return null;
            }
            TagDto dto = new TagDto();
            dto.setName(tag.getName());
            return dto;
        }

        // Convert TagDto to Tag
        public Tag toEntity(TagDto dto) {
            if (dto == null) {
                return null;
            }
            Tag tag = new Tag();
            tag.setName(dto.getName());
            return tag;
        }
    public static TagResponse toDtoWithId(Tag tag) {
        if (tag == null) {
            return null;
        }
        TagResponse dto = new TagResponse();
        dto.setId(tag.getId());
        dto.setName(tag.getName());
        return dto;
    }

        // Convert List<Tag> to List<TagDto>
        public List<TagDto> toDtoList(List<Tag> tags) {
            return tags.stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());
        }
    public static List<TagResponse> toDtoListWithId(List<Tag> tags) {
        if (tags == null) {
            return null;
        }
        return tags.stream()
                .map(TagMapper::toDtoWithId)
                .collect(Collectors.toList());
    }

        // Convert List<TagDto> to List<Tag>
        public List<Tag> toEntityList(List<TagDto> tagDtos) {
            return tagDtos.stream()
                    .map(this::toEntity)
                    .collect(Collectors.toList());
        }


}
