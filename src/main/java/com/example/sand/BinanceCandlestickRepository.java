package com.example.sand;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BinanceCandlestickRepository extends CrudRepository<BinanceCandlestick, Integer> {

//    @Query("select * from binance_candlestick where pair = ?1 order by close_time ASC limit 1")
//    BinanceCandlestick getOldestCandlestickByCurrencyPair(String pair);

}