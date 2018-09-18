package net.retrofit.rx


import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import rx.Subscriber
import rx.Subscription
import rx.schedulers.Schedulers

object RR {

    @JvmStatic
    fun main(args: Array<String>) {
        rr()
//        rxKotlinTest()

        getGithub()
        rxKotlinTest()
    }

    private fun rxKotlinTest() {
        val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

        list.toObservable() // extension function for Iterables
                .filter { it.length >= 5 }
                .subscribeBy(  // named arguments for lambda Subscribers
                        onNext = { println(it) },
                        onError = { it.printStackTrace() },
                        onComplete = { println("Done!") }
                )
    }

    private fun rr(): Subscription {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()

        val api = retrofit.create(Api::class.java)

//        val call = retrofit.create(RetrofitApi::class.java).post("hi/login", mapOf("username" to "catface", "password" to "root"))
//        call.enqueue(object : Callback<String> {
//            override function onResponse(call: Call<String>?, response: Response<String>?) {
//                println(response?.body())
//            }
//            override function onFailure(call: Call<String>?, t: Throwable?) {
//            }
//        })

        val subscribe = api.login(mapOf("username" to "catface", "password" to "root"))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .doOnNext {
                    println("do on next")
                }
                .subscribe(object : Subscriber<String>() {
                    override fun onError(e: Throwable?) {
                        println("onErr: ${e.toString()}")
                    }

                    override fun onNext(t: String?) {
                        println("onNext...: $t")
                    }

                    override fun onCompleted() {
                        println("onComplete: ")
                    }
                })

        return subscribe
//        subscribe.unsubscribe()
//        val unsubscribed = subscribe.isUnsubscribed
//        println(unsubscribed)
    }


    private fun getGithub() {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()

        val api = retrofit.create(Api::class.java)

        api.getGithub()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .doOnNext {
                    println("--=-=")
                }
                .subscribe(object : Subscriber<String>() {
                    override fun onError(e: Throwable?) {
                        println("onErr: ${e.toString()}")
                    }

                    override fun onNext(t: String?) {
                        println("onNext...: $t")
                    }

                    override fun onCompleted() {
                        println("onComplete: ")
                    }
                })
    }


}