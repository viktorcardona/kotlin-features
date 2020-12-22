package playground.`5rationals`

import java.math.BigInteger
import java.math.BigInteger.ONE
import java.math.BigInteger.ZERO
import java.math.MathContext

fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println("912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)

}

class Rational(numerator: BigInteger, denominator: BigInteger) : Comparable<Rational> {
    private val n: BigInteger
    private val d: BigInteger
    init {
        require(denominator != ZERO) {"denominator can not be zero"}
        val sign = if (numerator * denominator < ZERO) -ONE else ONE
        val gcd = getNumerator(sign, numerator).gcd(denominator.abs())
        n = getNumerator(sign, numerator) / gcd
        d = denominator.abs() / gcd
    }

    private fun getNumerator(sign: BigInteger, numerator: BigInteger): BigInteger = numerator.abs().multiply(sign)

    operator fun plus(other: Rational) = ((n * other.d) + (d * other.n)) divBy (d * other.d)
    operator fun minus(other: Rational) = ((n * other.d) - (d * other.n)) divBy (d * other.d)
    operator fun times(other: Rational) = (n * other.n) divBy (d * other.d)
    operator fun div(other: Rational) = (n * other.d) divBy (d * other.n)

    operator fun unaryMinus() = -n divBy this.d
    operator fun inc() = (n + d) divBy d

    override operator fun compareTo(other: Rational) = (value()).compareTo(other.value())

    private fun value() = n.toBigDecimal().divide(d.toBigDecimal(), MathContext.DECIMAL128)

    override fun toString(): String = if (d == ONE) "$n" else "$n/$d"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rational

        if (n != other.n) return false
        if (d != other.d) return false

        return true
    }

    override fun hashCode(): Int {
        var result = n.hashCode()
        result = 31 * result + d.hashCode()
        return result
    }

}
fun String.toRational(): Rational {
    val list = split("/")
    return if (list.size == 1) Rational(BigInteger(this), ONE)
    else Rational(BigInteger(list[0]), BigInteger(list[1]))
}

infix fun BigInteger.divBy(dd: BigInteger) = Rational(this, dd)
infix fun Long.divBy(dd: Long) = Rational(BigInteger.valueOf(this), BigInteger.valueOf(dd))
infix fun Int.divBy(dd: Int) = Rational(BigInteger.valueOf(this.toLong()), BigInteger.valueOf(dd.toLong()))
