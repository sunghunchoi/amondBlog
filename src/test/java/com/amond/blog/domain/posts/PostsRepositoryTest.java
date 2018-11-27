package com.amond.blog.domain.posts;

import com.amond.blog.repository.PostsRepository;
import com.amond.blog.service.PostsService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    private PostsService postService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup(){
        /*
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 repository 전체 비우는 코드
         */
        postsRepository.deleteAll();
    }

    @Test
    public void getAllPost(){
        //given
        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("csh6222sp@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        //assertThat(posts.getTitle(), is("테스트 게시글"));
        //assertThat(posts.getContent(), is("테스트 본문"));
    }

    @Test
    public void saveBaseTimeEntity(){
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                        .title("Test2")
                        .content("contents2")
                        .author("Csh5222sp@gamil.com")
                        .build()
        );

        //when
        List<Posts> postsList = postsRepository.findAll();

//        //then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }

    @Test
    public void savePostsDataByService(){
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                                    .author("cshiof@gamil.com")
                                    .content("Test")
                                    .title("test Title")
                                    .build();

        //when
        postService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }


    /*
        //given,//when,//then
        1.given
         : 테스트 기반 환경을 구축하는 단계
         : 여기선
         : @builder의 사용법도 같이 확인
        2.when
         : 테스트 하고자 하는 행위 선언
         : 여기선 Posts가 DB에 insert되는것을 확인하기 위함
        3.then
         : 테스트 결과 검증
         : 실제로 DB에 insert되었는지 확인하기 위해 조회후, 입력된 값 확인.

     */
}
