import java.util.*

// Интерфейс для подписчиков
interface Subscriber {
    fun update(news: String)
}

// Класс для рассылки новостей подписчикам
class NewsPoster {
    private val subscribers: MutableList<Subscriber> = mutableListOf()

    // Метод для подписки на новости
    fun subscribe(subscriber: Subscriber) {
        subscribers.add(subscriber)
    }

    // Метод для отписки от новостей
    fun unsubscribe(subscriber: Subscriber) {
        subscribers.remove(subscriber)
    }

    // новости подписчикам
    fun sendNews(news: String) {
        for (subscriber in subscribers) {
            subscriber.update(news)
        }
    }
}
class ExampleSubscriber(private val name: String) : Subscriber {
    override fun update(news: String) {
        println("$name получил новость: $news")
    }
}

fun main() {
    val newsPoster = NewsPoster()

    val subscriber1 = ExampleSubscriber("Подписчик 1")
    val subscriber2 = ExampleSubscriber("Подписчик 2")
    val subscriber3 = ExampleSubscriber("Подписчик 3")

    newsPoster.subscribe(subscriber1)
    newsPoster.subscribe(subscriber2)
    newsPoster.subscribe(subscriber3)

    newsPoster.sendNews("Новость 1: Важное объявление!")
    newsPoster.sendNews("Новость 2: Большое событие произошло!")
    newsPoster.sendNews("Новость 3: Погода на выходных")

    newsPoster.unsubscribe(subscriber2)

    newsPoster.sendNews("Новость 4: Специальное предложение для подписчиков!")

    // Теперь subscriber2 не получит новости, так как он отписался
}
