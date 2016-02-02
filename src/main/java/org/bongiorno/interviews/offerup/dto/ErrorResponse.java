package org.bongiorno.interviews.offerup.dto;

public class ErrorResponse {
    private Integer status;
    private Content content;

    public ErrorResponse() {
    }

    public ErrorResponse(Integer status, String message) {
        this.status = status;
        this.content = new Content(message);
    }

    public Integer getStatus() {
        return status;
    }

    public Content getContent() {
        return content;
    }

    private static class Content {
        private String message;

        public Content() {
        }

        public Content(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
