package com.prof.rssparser.core

import android.os.Build
import com.prof.rssparser.Article
import com.prof.rssparser.Channel
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNull
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class CoreXMLParserImageChannelItunesTest {
    private lateinit var articleList: MutableList<Article>
    private lateinit var article: Article
    private val feedPath = "/feed-test-image-channel-itunes.xml"
    private lateinit var channel: Channel

    @Before
    fun setUp() {
        val inputStream = javaClass.getResourceAsStream(feedPath)!!
        val feed = inputStream.bufferedReader().use { it.readText() }
        channel = CoreXMLParser.parseXML(feed)
        articleList = channel.articles
        article = articleList[0]
    }

    @Test
    fun channelTitle_isCorrect() {
        Assert.assertEquals(channel.title, "This American Life")
    }

    @Test
    fun channelDesc_isCorrect() {
        Assert.assertEquals(channel.description, "This American Life is a weekly public radio show, heard by 2.2 million people on more than 500 stations. Another 2.5 million people download the weekly podcast. It is hosted by Ira Glass, produced in collaboration with Chicago Public Media, delivered to stations by PRX The Public Radio Exchange, and has won all of the major broadcasting awards.")
    }

    @Test
    fun channelLink_isCorrect() {
        Assert.assertEquals(channel.link, "https://www.thisamericanlife.org")
    }

    @Test
    fun channelImageTitle_isCorrect() {
        Assert.assertNull(channel.image?.title)
    }

    @Test
    fun channelImageLink_isCorrect() {
        Assert.assertNull(channel.image?.link)
    }

    @Test
    fun channelImageUrl_isCorrect() {
        Assert.assertEquals(channel.image?.url, "https://files.thisamericanlife.org/sites/all/themes/thislife/img/tal-name-1400x1400.png")
    }

    @Test
    fun channelImageDescription_isCorrect() {
        Assert.assertNull(channel.image?.description)
    }

    @Test
    fun channelLastBuild_isCorrect() {
        assertNull(channel.lastBuildDate)
    }

    @Test
    fun channelUpdatePeriod_isCorrect() {
        Assert.assertNull(channel.updatePeriod)
    }

    @Test
    @Throws
    fun size_isCorrect() {
        Assert.assertEquals(articleList.size, 10)
    }

    @Test
    @Throws
    fun duration_isCorrect() {
        Assert.assertEquals(articleList[1].duration, 4703)
    }

    @Test
    @Throws
    fun length_isCorrect() {
        Assert.assertEquals(articleList[1].length, 49853111)
    }

    @Test
    @Throws
    fun second_duration_isCorrect() {
        Assert.assertEquals(articleList[2].duration, 6789)
    }

    @Test
    @Throws
    fun title_isCorrect() {
        Assert.assertEquals(article.title, "513: 129 Cars")
    }

    @Test
    @Throws
    fun author_isCorrect() {
        Assert.assertEquals(article.author, "This American Life")
    }

    @Test
    @Throws
    fun link_isCorrect() {
        Assert.assertEquals(article.link, "http://feed.thisamericanlife.org/~r/talpodcast/~3/Ft_kvhWEuxo/129-cars")
    }

    @Test
    @Throws
    fun pubDate_isCorrect() {
        Assert.assertEquals(article.pubDate, "Sun, 05 Jul 2020 18:00:00 -0400")
    }

    @Test
    @Throws
    fun description_isPresent() {
        Assert.assertEquals(article.description, "We spend a month at a Jeep dealership on Long Island as they try to make their monthly sales goal: 129 cars. If they make it, they'll get a huge bonus from the manufacturer, possibly as high as \$85,000 — enough to put them in the black for the month. If they don't make it, it'll be the second month in a row. So they pull out all the stops.<img src=\"http://feeds.feedburner.com/~r/talpodcast/~4/Ft_kvhWEuxo\" height=\"1\" width=\"1\" alt=\"\"/>")
    }

    @Test
    @Throws
    fun content_isCorrect() {
        Assert.assertNull(article.content)
    }

    @Test
    @Throws
    fun image_isCorrect() {
        Assert.assertEquals(article.image, "http://feeds.feedburner.com/~r/talpodcast/~4/Ft_kvhWEuxo")
    }

    @Test
    @Throws
    fun categories_isCorrect() {
        assert(article.categories.isEmpty())
    }

    @Test
    @Throws
    fun guid_isCorrect() {
        Assert.assertEquals(article.guid, "37160 at https://www.thisamericanlife.org")
    }

    @Test
    @Throws
    fun audio_iCorrect() {
        Assert.assertEquals(article.audio, "https://www.podtrac.com/pts/redirect.mp3/dovetail.prxu.org/188/22319bfa-6d3a-4f00-a4bd-eee1909d76bf/513.mp3")
    }

    @Test
    @Throws
    fun sourceName_iCorrect() {
        Assert.assertNull(article.sourceName)
    }

    @Test
    @Throws
    fun sourceUrl_iCorrect() {
        Assert.assertNull(article.sourceUrl)
    }

    @Test
    @Throws
    fun video_isCorrect() {
        Assert.assertNull(article.video)
    }
}