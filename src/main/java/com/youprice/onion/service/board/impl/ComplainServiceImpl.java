package com.youprice.onion.service.board.impl;

import com.youprice.onion.dto.board.ComplainDTO;
import com.youprice.onion.dto.board.ComplainFormDTO;
import com.youprice.onion.entity.board.Complain;
import com.youprice.onion.entity.chat.Chatroom;
import com.youprice.onion.entity.member.Member;
import com.youprice.onion.entity.product.Product;
import com.youprice.onion.repository.board.ComplainRepository;
import com.youprice.onion.repository.member.MemberRepository;
import com.youprice.onion.repository.product.ProductRepository;
import com.youprice.onion.service.board.ComplainService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComplainServiceImpl implements ComplainService {

    private final ComplainRepository complainRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    //private final ChatroomRepository chatroomRepository;

    @Override
    public ComplainDTO findComplainDTO(Long id) {
        return complainRepository.findById(id).map(ComplainDTO::new).orElse(null);
    }

    @Override
    public void saveComplain(ComplainFormDTO form) {
        Member member = memberRepository.findById(form.getMemberId()).orElse(null);
        Product product = productRepository.findById(form.getProductId()).orElse(null);
        Long targetId = product.getMember().getId();

        //memberRepository.
        //Chatroom chatroom = chatroomRepository.findById(form.getChatroomId()).orElse(null);

        Complain complain = new Complain(member,product,null, form.getComplainType(), form.getComplainContent(),"대기");
        complainRepository.save(complain);
    }

//    @Override
//    public Page<ComplainDTO> findAll(Pageable pageable) {
//        return complainRepository.findAll(pageable).map(ComplainDTO::new);
//    }
}