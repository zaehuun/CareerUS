package com.project.backend.market.service;

import com.project.backend.common.exceptions.CustomException;
import com.project.backend.common.exceptions.dto.ErrorCode;
import com.project.backend.common.paging.PageResultDto;
import com.project.backend.market.domain.Market;
import com.project.backend.market.domain.MarketRepository;
import com.project.backend.market.domain.MarketTag;
import com.project.backend.market.domain.Status;
import com.project.backend.market.dto.MarketRequestDto;
import com.project.backend.market.dto.MarketResponseDto;
import com.project.backend.market.dto.MarketsResponseDto;
import com.project.backend.post.domain.Post;
import com.project.backend.post.domain.Tag;
import com.project.backend.post.dto.PostRequestDto;
import com.project.backend.post.dto.PostResponseDto;
import com.project.backend.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class MarketService {

    private final MarketRepository marketRepository;

    public MarketResponseDto getMarket(Long id){
        Market market = marketRepository.findById(id)
                .orElseThrow(()->new
                        CustomException(ErrorCode.INVALID_POST));
        market.setView(market.getView() + 1);
        return MarketResponseDto.builder()
                .title(market.getTitle())
                .writer(market.getUser().getName())
                .content(market.getContent())
                .marketTags(market.getTags().stream().map(MarketTag::getName).collect(Collectors.toList()))
                .date(market.getCreateDate())
                .status(market.getStatus())
                .view(market.getView())
                .build();
    }
    public MarketResponseDto saveMarket(User user, MarketRequestDto requestDto){
        Market market = Market.builder()
                .title(requestDto.getTitle())
                .user(user)
                .content(requestDto.getContent())
                .status(Status.STATUS_SELL)
                .view(0L)
                .build();
        List<MarketTag> tags = requestDto.getMarketTags().stream().map(name->new MarketTag(name,market)).collect(Collectors.toList());
        market.setTags(tags);
        marketRepository.save(market);
        return MarketResponseDto.builder()
                .id(market.getId())
                .writer(market.getUser().getUsername())
                .status(market.getStatus())
                .build();
    }

    public Long updateMarket(Long id, MarketRequestDto requestDto){
        Market market = marketRepository.findById(id)
                .orElseThrow(()->new
                        CustomException(ErrorCode.INVALID_POST));
        market.update(requestDto);
        return market.getId();
    }

    public void deleteMarket(Long id){
        Market market = marketRepository.findById(id)
                .orElseThrow(()->new
                        CustomException(ErrorCode.INVALID_POST));
        marketRepository.delete(market);
    }

    public PageResultDto<MarketsResponseDto,Market> getList(int num){
        int pageNum = num == 0 ? 0 : num-1;
        Page<Market> markets = marketRepository.findAll(PageRequest.of(pageNum,10, Sort.by("id").descending()));
        Function<Market, MarketsResponseDto> fn = (entity -> entityToDto(entity));
        return new PageResultDto<>(markets,fn);
    }


      public void inputTestMarket(User user){
        for(int i = 0; i < 40; i++){
            Market m = Market.builder()
                    .title("제목입니다"+Integer.toString(i))
                    .content("내용입니다" +Integer.toString(i))
                    .user(user)
                    .view(0L)
                    .build();
            List<MarketTag> tags = new ArrayList<MarketTag>();
            for(int j = 0; j < 3; j++){
                MarketTag tag = MarketTag.builder()
                        .name("hi"+Integer.toString(i) + Integer.toString(j))
                        .market(m)
                        .build();
                tags.add(tag);
            }
            m.setTags(tags);
            marketRepository.save(m);
        }
    }

    private MarketsResponseDto entityToDto(Market entity){
        return MarketsResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .writer(entity.getUser().getName())
                .tag(entity.getTags().stream().map(MarketTag::getName).collect(Collectors.toList()))
                .date(entity.getCreateDate())
                .status(entity.getStatus())
                .view(entity.getView())
                .build();
    }

}