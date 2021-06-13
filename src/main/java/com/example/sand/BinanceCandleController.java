package com.example.sand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/v1/candle/binance") // This means URL's start with /demo (after Application path)
public class BinanceCandleController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private BinanceCandlestickRepository binanceCandlestickRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody
    ResponseEntity<BinanceCandlestick> addNewCandlestick (@RequestBody BinanceCandlestick binanceCandlestick) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        binanceCandlestickRepository.save(binanceCandlestick);
        return ResponseEntity
                .created(URI.create(String.format("/v1/candle/binance/%s", binanceCandlestick.getId())))
                .body(binanceCandlestick);
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Optional<BinanceCandlestick> getCandlestickById(@PathVariable int id) {
        // This returns a JSON or XML with the users
        return binanceCandlestickRepository.findById(id);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<BinanceCandlestick> getAllCandlesticks() {
        // This returns a JSON or XML with the users
        return binanceCandlestickRepository.findAll();
    }

    @GetMapping(path="/getOldestCandlestickByCurrencyPair/{pair}")
    public @ResponseBody BinanceCandlestick getOldestCandlestickByCurrencyPair(@PathVariable String pair) {
        // This returns a JSON or XML with the users
        return binanceCandlestickRepository.getOldestCandlestickByCurrencyPair(pair);
    }
}