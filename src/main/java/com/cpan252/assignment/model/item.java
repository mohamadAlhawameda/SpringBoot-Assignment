package com.cpan252.assignment.model;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
@Data
@Builder
public class item {
    @Id
    private Long id;
    @NotBlank
    private String name;
    private Anime brand;
    @Min(2021)
    private int prucdedDate;
    @Min(1000)
    private double price;

    public enum Anime{
        NIKE("Nikw"), HM("HM"), GUCCI("GUCCI");

        private String title;

        private Anime(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }
}
