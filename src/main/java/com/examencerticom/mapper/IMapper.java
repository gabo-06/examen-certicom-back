package com.examencerticom.mapper;

public interface IMapper<I, O> {

    public O map(I in);
}
