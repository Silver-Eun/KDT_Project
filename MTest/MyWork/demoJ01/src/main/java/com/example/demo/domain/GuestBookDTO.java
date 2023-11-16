package com.example.demo.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuestBookDTO {
	private long gno;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate, modDate;
}
