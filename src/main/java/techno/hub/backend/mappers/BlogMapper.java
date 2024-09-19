package techno.hub.backend.mappers;

import org.springframework.stereotype.Component;
import techno.hub.backend.dtos.BlogDto;
import techno.hub.backend.dtos.BlogResponse;
import techno.hub.backend.dtos.TagDto;
import techno.hub.backend.dtos.TagResponse;
import techno.hub.backend.entities.Blog;
import techno.hub.backend.entities.Tag;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BlogMapper {

    // Convert Tag to TagDto
    public TagDto tagToDto(Tag tag) {
        if (tag == null) {
            return null;
        }
        TagDto dto = new TagDto();
        dto.setName(tag.getName());
        return dto;
    }

    // Convert TagDto to Tag
    public Tag tagToEntity(TagDto dto) {
        if (dto == null) {
            return null;
        }
        Tag tag = new Tag();
        tag.setName(dto.getName());
        // Avoid setting 'blogs' to prevent circular references
        return tag;
    }

    // Convert Blog to BlogDto
    public BlogDto blogToDto(Blog blog) {
        if (blog == null) {
            return null;
        }
        BlogDto dto = new BlogDto();
        dto.setTitle(blog.getTitle());
        dto.setContent(blog.getContent());
        dto.setCreatedAt(blog.getCreatedAt());
        dto.setUpdatedAt(blog.getUpdatedAt());
        dto.setImageUrl(blog.getImageUrl());

        // Convert List<Tag> to List<TagDto>
        List<TagDto> tagDtos = blog.getTags().stream()
                .map(this::tagToDto)
                .collect(Collectors.toList());
        dto.setTags(tagDtos);

        return dto;
    }

    // Convert BlogDto to Blog
    public Blog blogToEntity(BlogDto dto) {
        if (dto == null) {
            return null;
        }
        Blog blog = new Blog();
        blog.setTitle(dto.getTitle());
        blog.setContent(dto.getContent());
        blog.setCreatedAt(dto.getCreatedAt());
        blog.setUpdatedAt(dto.getUpdatedAt());
        blog.setImageUrl(dto.getImageUrl());

        // Convert List<TagDto> to List<Tag>
        List<Tag> tags = dto.getTags().stream()
                .map(this::tagToEntity)
                .collect(Collectors.toList());
        blog.setTags(tags);

        return blog;
    }

    // Convert List<Blog> to List<BlogDto>
    public List<BlogDto> blogToDtoList(List<Blog> blogs) {
        return blogs.stream()
                .map(this::blogToDto)
                .collect(Collectors.toList());
    }

    public static BlogResponse toDtoWithId(Blog blog) {
        if (blog == null) {
            return null;
        }

        BlogResponse dto = new BlogResponse();
        dto.setId(blog.getId());
        dto.setTitle(blog.getTitle());
        dto.setContent(blog.getContent());
        dto.setCreatedAt(blog.getCreatedAt());
        dto.setUpdatedAt(blog.getUpdatedAt());
        dto.setImageUrl(blog.getImageUrl());

        if (blog.getTags() != null) {
            List<TagResponse> tagDtos = blog.getTags()
                    .stream()
                    .map(TagMapper::toDtoWithId)
                    .collect(Collectors.toList());
            dto.setTags(tagDtos);
        }

        return dto;
    }
    public static List<BlogResponse> toDtoListWithIds(List<Blog> blogs) {
        if (blogs == null) {
            return null;
        }
        return blogs.stream()
                .map(BlogMapper::toDtoWithId)
                .collect(Collectors.toList());
    }


    // Convert List<BlogDto> to List<Blog>
    public List<Blog> dtoToBlogList(List<BlogDto> blogDtos) {
        return blogDtos.stream()
                .map(this::blogToEntity)
                .collect(Collectors.toList());
    }
}
