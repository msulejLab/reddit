package pl.lodz.p.iis.ppkwu.reddit;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.http.oauth.Credentials;
import net.dean.jraw.http.oauth.OAuthData;
import net.dean.jraw.http.oauth.OAuthException;
import net.dean.jraw.models.Subreddit;
import pl.lodz.p.iis.ppkwu.reddit.api.Reddit;
import pl.lodz.p.iis.ppkwu.reddit.api.RedditBuilder;
import pl.lodz.p.iis.ppkwu.reddit.api.Util;

public class Application {

    public static void main(String[] args) throws OAuthException {
/*
        UserAgent myUserAgent = UserAgent.of("desktop", "pl.lodz.p.iis.ppkwu.reddit", "v1", "ppkwu-reddit");
        RedditClient redditClient = new RedditClient(myUserAgent);
        Credentials credentials = Credentials.script("ppkwu-reddit", "ppkwu-reddit", "XWHE1d691V9S4A", "r_5dy9HgYFYjG4aVIrgVenXZhCk");

        OAuthData authData = redditClient.getOAuthHelper().easyAuth(credentials);
        redditClient.authenticate(authData);
*/

        RedditBuilder redditBuilder = Util.redditBuilder();
        Reddit reddit = redditBuilder.build();
    }
}