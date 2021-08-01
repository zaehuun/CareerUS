package com.project.backend.market;

import com.project.backend.common.ImageUtil;
import com.project.backend.common.paging.PageResultDto;
import com.project.backend.market.domain.Market;
import com.project.backend.market.dto.ImageResponseDto;
import com.project.backend.market.dto.MarketRequestDto;
import com.project.backend.market.dto.MarketResponseDto;
import com.project.backend.market.dto.MarketsResponseDto;
import com.project.backend.market.service.MarketService;
import com.project.backend.security.annotation.CurrentUser;
import com.project.backend.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class MarketController {

    private final MarketService marketService;

    @GetMapping("/api/market/{id}")
    public ResponseEntity<MarketResponseDto> getMarket(@CurrentUser User user, @PathVariable("id") Long id){
        return new ResponseEntity<>(marketService.getMarket(id), HttpStatus.OK);
    }
//
    @PostMapping("/api/markets")
    public ResponseEntity<MarketResponseDto> saveMarket(@CurrentUser User user, @RequestBody MarketRequestDto requestDto){
        return new ResponseEntity<>(marketService.saveMarket(user, requestDto), HttpStatus.OK);
    }

    @PutMapping("/api/market/{id}")
    public ResponseEntity<Long> updateMarket(@PathVariable("id") Long id, @RequestBody MarketRequestDto requestDto){
        return new ResponseEntity<>(marketService.updateMarket(id,requestDto), HttpStatus.OK);
    }

    @DeleteMapping("/api/market/{id}")
    public ResponseEntity<String> deleteMarket(@PathVariable Long id){
        marketService.deleteMarket(id);
        return new ResponseEntity<>("삭제 완료", HttpStatus.OK);
    }

    @GetMapping("/api/markets")
    public ResponseEntity<PageResultDto<MarketsResponseDto, Market>> getMarketList(@RequestParam(value = "page", required = false, defaultValue = "0") int pageNum){
        System.out.println("pageNum = " + pageNum);
        return new ResponseEntity<>(marketService.getList(pageNum),HttpStatus.OK);
    }

    @GetMapping("/api/market/test")
    public ResponseEntity<Long> inputUser(@CurrentUser User user){
        System.out.println(123);
        marketService.inputTestMarket(user);
        return new ResponseEntity<>(1L,HttpStatus.OK);
    }

    @PostMapping("/api/upload_market")
    public ResponseEntity<ImageResponseDto> upload(@RequestParam("image") MultipartFile img) throws IOException {
        ImageResponseDto dto = new ImageResponseDto(ImageUtil.marketImgSave(img));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
