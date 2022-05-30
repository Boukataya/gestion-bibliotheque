package com.eBiblio;

import com.eBiblio.enums.Categorie;
import com.eBiblio.models.domaine.dto.*;
import com.eBiblio.models.domaine.mappers.DocumentConverter;
import com.eBiblio.models.domaine.mappers.MemberConverter;
import com.eBiblio.services.document.IDocumentService;
import com.eBiblio.services.member.IMemberService;
import com.eBiblio.services.reservation.IReservationService;
import com.eBiblio.services.user.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableWebMvc
public class EBiblioApplication {

    public static void main(String[] args) {
        SpringApplication.run(EBiblioApplication.class, args);

    }

    @Bean
    CommandLineRunner Start(IUserService userService, IMemberService memberService, IDocumentService documentService, IReservationService reservationService) {
        return args -> {
            String url = "https://placehold.jp/300x400.png";
            userService.cleanDataBase();
            DocumentDto documentDto_1 = new DocumentDto(" A Clash of Kings", " A comet the color of blood and flame cuts across the sky. Two great leaders—Lord Eddard Stark and Robert Baratheon—who hold sway over an age of enforced peace are dead, victims of royal treachery. Now, from the ancient citadel of Dragonstone to the forbidding shores of Winterfell, chaos reigns. Six factions struggle for control of a divided land and the Iron Throne of the Seven Kingdoms, preparing to stake their claims through tempest, turmoil, and war. ", url, Categorie.LIVRE, "George R.R. Martin", "Bantam", new Date(), 60);
            DocumentDto documentDto_2 = new DocumentDto("Love on the Brain", "From the New York Times bestselling author of The Love Hypothesis comes a new STEMinist rom-com in which a scientist is forced to work on a project with her nemesis--with explosive results. ", url, Categorie.LIVRE, "Ali Hazelwood", "Berkley Books", new Date(), 25);
            DocumentDto documentDto_3 = new DocumentDto("Harry Potter", "Harry Potter is a series of seven fantasy novels written by British author J. K. Rowling. The novels chronicle the lives of a young wizard, Harry Potter, and his friends Hermione Granger and Ron Weasley, all of whom are students at Hogwarts School of Witchcraft and Wizardry.", url, Categorie.LIVRE, "J. K. Rowling", "PotterMore Publishing", new Date(), 40);
            DocumentDto documentDto_4 = new DocumentDto("Rich Dad Poor Dad", "Rich Dad Poor Dad is a 1997 book written by Robert T. Kiyosaki and Sharon Lechter. It advocates the importance of financial literacy, financial independence and building wealth through investing in assets, real estate investing, starting and owning businesses, as well as increasing one's financial intelligence.", url, Categorie.LIVRE, "Robert Kiyosaki, Sharon Lechter", "Warner Books", new Date(), 65);
            DocumentDto documentDto_5 = new DocumentDto("Klara and the Sun", "Klara and the Sun is the eighth novel by the Nobel Prize-winning British writer Kazuo Ishiguro, published on 2 March 2021. It is a dystopian science fiction story.", url, Categorie.LIVRE, "Kazuo Ishiguro", "Faber and Faber", new Date(), 35);
            DocumentDto documentDto_6 = new DocumentDto("The Alchemist", "The Alchemist is a story of a young shepherd , named Santiago, who is transformed into a human being after being magically cured of a rare disease. He is then given the power to make others human, and is told that he is now a human being, but that he is not a human being. The story is told by the protagonist, Santiago, who is a young shepherd, and is told that he is a human being, but that he is not a human being.", url, Categorie.LIVRE, "Paulo Coelho", "HarperCollins Publishers", new Date(), 45);
            DocumentDto documentDto_7 = new DocumentDto("Brief History of Time", "Brief History of Time is a book by Stephen Hawking, published in 1988. It is the first book in the Hawking Saga, and is the first book in the series to be published in a hardcover edition.", url, Categorie.LIVRE, "Stephen Hawking", "HarperCollins Publishers", new Date(), 55);
            DocumentDto documentDto_8 = new DocumentDto("Les Miserables", "Les Miserables is a novel by Victor Hugo, published in 1862. The novel is set in the fictional city of Paris, France, in the late 18th century. The story is about a young", url, Categorie.LIVRE, "Victor Hugo", "Victor Hugo", new Date(), 25);
            DocumentDto documentDto_9 = new DocumentDto("The Lord of the Rings", "The Lord of the Rings is an epic high fantasy novel written by English author J. R. R. Tolkien. The story began as a sequel to Tolkien's 1937 fantasy novel The Hobbit, but eventually developed into a much larger work. Written in stages between 1937 and 1949, The Lord of the Rings is one of the best-selling novels in the English language, with over 150 million copies sold", url, Categorie.LIVRE, "J. R. R. Tolkien", "Allen & Unwin", new Date(), 35);
            DocumentDto documentDto_10 = new DocumentDto("The Hobbit", "The Hobbit, or There and Back Again is a children's fantasy novel by English author J. R. R. Tolkien. It was published on 21 September 1937 by Dunlop and Crown Publishers, and is considered by many to be the first of the Lord of the Rings novels. The story follows the quest of home-loving hobbit Bilbo Baggins to the Lonely Mountain, to find the One Ring, and to make his escape from the dragon-infested", url, Categorie.LIVRE, "J. R. R. Tolkien", "Allen & Unwin", new Date(), 25);
            DocumentDto documentDto_11 = new DocumentDto("The Hunger Games", "The Hunger Games is a dystopian novel written by the American author Suzanne Collins. It follows the lives of 12-year-old Katniss Everdeen, who voluntarily takes part in the televised Hunger Games, an event that is designed to force teenagers to fight to the death", url, Categorie.LIVRE, "Suzanne Collins", "Scholastic", new Date(), 35);
            DocumentDto documentDto_12 = new DocumentDto("The Da Vinci Code", "The Da Vinci Code is a mystery novel written by Dan Brown. It is Brown's second novel and first published in 2003. The book was serialized in the United States for the first time, and was later adapted into a film and television series. The novel was adapted by Robert Langdon, Paul Leighton, and Christopher Priest", url, Categorie.LIVRE, "Dan Brown", "Penguin Books", new Date(), 25);

            documentService.saveDocument(documentDto_1);
            documentService.saveDocument(documentDto_2);
            documentService.saveDocument(documentDto_3);
            documentService.saveDocument(documentDto_4);
            documentService.saveDocument(documentDto_5);
            documentService.saveDocument(documentDto_6);
            documentService.saveDocument(documentDto_7);
            documentService.saveDocument(documentDto_8);
            documentService.saveDocument(documentDto_9);
            documentService.saveDocument(documentDto_10);
            documentService.saveDocument(documentDto_11);
            documentService.saveDocument(documentDto_12);

            userService.saveRole(new RoleDto("ADMIN"));
            userService.saveRole(new RoleDto("PERMANENT"));
            userService.saveRole(new RoleDto("TEMPORAIRE"));

            RoleDto roleAdmin = userService.getRoleByName("ADMIN");
            RoleDto rolePermanent = userService.getRoleByName("PERMANENT");
            RoleDto roleTemporaire = userService.getRoleByName("TEMPORAIRE");

            UserDto admin1 = new UserDto("youness", "123456", List.of(roleAdmin));
            UserDto clientPermanent_1 = new UserDto("clientPermanent_1", "cp1234", List.of(rolePermanent));
            UserDto clientPermanent_2 = new UserDto("clientPermanent_2", "cp1234", List.of(rolePermanent));
            UserDto clientTemporaire_1 = new UserDto("clientTemporaire_1", "ct1234", List.of(roleTemporaire));
            UserDto clientTemporaire_2 = new UserDto("clientTemporaire_2", "ct1234", List.of(roleTemporaire));

            userService.saveUser(admin1);
            userService.saveUser(clientPermanent_1);
            userService.saveUser(clientPermanent_2);
            userService.saveUser(clientTemporaire_1);
            userService.saveUser(clientTemporaire_2);

            MemberDto membre_1 = new MemberDto("Jamal", "Debouz", "jamaldebouz@gmail.com", "0610187845", true);
            MemberDto membre_2 = new MemberDto("Driss", "Boukataya", "drissbouka@gmail.com", "071562541", true);
            MemberDto membre_3 = new MemberDto("Sanae", "Elferi", "sanaeelferi@gmail.com", "0652418596", true);

            memberService.saveMember(membre_1);
            memberService.saveMember(membre_2);
            memberService.saveMember(membre_3);

            MemberDto membre_1b = memberService.getMemberById(1L);
            MemberDto membre_2b = memberService.getMemberById(2L);

            DocumentDto document_1 = documentService.getDocumentById(1L);
            DocumentDto document_2 = documentService.getDocumentById(2L);
            DocumentDto document_3 = documentService.getDocumentById(3L);

            ReservationDto reservationDto_1 = new ReservationDto(new Date(), MemberConverter.toMember(membre_1b), DocumentConverter.toDocument(document_1));
            ReservationDto reservationDto_2 = new ReservationDto(new Date(), MemberConverter.toMember(membre_1b), DocumentConverter.toDocument(document_2));
            ReservationDto reservationDto_3 = new ReservationDto(new Date(), MemberConverter.toMember(membre_1b), DocumentConverter.toDocument(document_3));
            ReservationDto reservationDto_4 = new ReservationDto(new Date(), MemberConverter.toMember(membre_2b), DocumentConverter.toDocument(document_1));
            ReservationDto reservationDto_5 = new ReservationDto(new Date(), MemberConverter.toMember(membre_2b), DocumentConverter.toDocument(document_2));
            ReservationDto reservationDto_6 = new ReservationDto(new Date(), MemberConverter.toMember(membre_2b), DocumentConverter.toDocument(document_3));

            reservationService.addReservation(reservationDto_1);
            reservationService.addReservation(reservationDto_2);
            reservationService.addReservation(reservationDto_3);
            reservationService.addReservation(reservationDto_4);
            reservationService.addReservation(reservationDto_5);
            reservationService.addReservation(reservationDto_6);

        };

    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}
