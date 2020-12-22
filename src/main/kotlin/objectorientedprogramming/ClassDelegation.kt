package objectorientedprogramming

interface Repository {
    fun getById(id: Int): String
    fun getAll(): List<String>
}

interface Logger {
    fun logAll()
}

class ControllerWithoutDelegation(
        val repository: Repository,
        val logger: Logger
    ) : Repository, Logger {

    override fun getById(id: Int): String {
        TODO("Not yet implemented")
    }
    override fun getAll(): List<String> {
        TODO("Not yet implemented")
    }
    override fun logAll() {
        TODO("Not yet implemented")
    }
}

/**
 *  Here we go with class Delegation:
 *
 *      by:
 *          Implements an interface by delegating to .....
 *
 */
class Controller(
        val repository: Repository,
        val logger: Logger
    ) : Repository by repository, Logger by logger
