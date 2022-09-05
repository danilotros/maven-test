package starter.wikipedia;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import net.serenitybdd.screenplay.annotations.CastMember;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenSearchingForTerms {

    @CastMember(name = "Wendy")
    Actor wendy;

    @Test
    void searchBySingleKeyword() {
        wendy.attemptsTo(
                Navigate.toTheHomePage(),
                Search.byKeyword("Everest")
        );
        wendy.should(
                seeThat("Validation message",DisplayedArticle.firstHeading(),equalTo("Monte Everest"))
        );
    }
}
