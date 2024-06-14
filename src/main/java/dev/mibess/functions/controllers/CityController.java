package dev.mibess.functions.controllers;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CityController {

    private final ChatClient chatClient;

    public CityController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("cities")
    public String cities(@RequestBody String message) {
        var systemMessage = new SystemMessage(
                "You are a helpful AI assistent answering questions about cities around the world");
        var userMessage = new UserMessage(message);

        var chatOptions = OpenAiChatOptions.builder().withFunction("currentWeatherFunction").build();

        var chatResponse = chatClient.prompt(new Prompt(List.of(systemMessage, userMessage), chatOptions));

        return chatResponse.call().content();

    }
}