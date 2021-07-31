package com.project.backend.common.paging;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@Setter
public class PageResultDto<DTO,EN> { //DTO - dto, En - Entity
    //DTO 리스트
    private List<DTO> posts;
//    ctx.body = {
//        posts: posts,
//        currentPage: page, //현재페이지
//        limit: limit, //한페이지에 보여줄 수
//        count: postCount, //전체게시글수
//    };

    private long count;
    //현재 페이지 번호
    private int currentPage;
    //페이지 당 dto 수
    private int limit;



    public PageResultDto(Page<EN> result, Function<EN,DTO> fn){
        posts = result.stream().map(fn).collect(Collectors.toList());
        count=result.getTotalElements();
        currentPage = result.getTotalPages();

        makePageList(result.getPageable());
    }

    private void makePageList(Pageable pageable){
        this.currentPage = pageable.getPageNumber() + 1;
        this.limit = pageable.getPageSize();

        int tmpEnd = (int)(Math.ceil(currentPage/5.0)) * 5;

//        start = tmpEnd - 4;
//
//        prev = start > 1;
//        end = totalPage > tmpEnd ? tmpEnd : totalPage;
//
//        next = totalPage > tmpEnd;
//
//        pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    }


//https://m.blog.naver.com/PostView.nhn?isHttpsRedirect=true&blogId=rorean&logNo=221609868273&categoryNo=11&proxyReferer=
//    {
//        "content" : [ {
//        "@id" : "1",
//                "seq" : 8,
//                "userId" : "user8",
//                "password" : "pass8",
//                "name" : "may",
//                "posts" : [ {
//            "@id" : "2",
//                    "seq" : 8,
//                    "title" : "안녕하세요8",
//                    "content" : "반가워요",
//                    "writer" : {
//                "@ref" : "1"
//            },
//            "wedding" : null
//        } ]
//    }],
//        "pageable" : {
//        "sort" : {
//            "sorted" : true,
//                    "unsorted" : false,
//                    "empty" : false
//        },
//        "offset" : 0,
//                "pageSize" : 2,
//                "pageNumber" : 0,
//                "paged" : true,
//                "unpaged" : false
//    },
//        "last" : false,
//            "totalPages" : 3,
//            "totalElements" : 5,
//            "size" : 2,
//            "number" : 0,
//            "numberOfElements" : 2,
//            "first" : true,
//            "sort" : {
//        "sorted" : true,
//                "unsorted" : false,
//                "empty" : false
//    },
//        "empty" : false
//    }
}
