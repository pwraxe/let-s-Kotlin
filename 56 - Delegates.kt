/**
 * Delegates mean to remove boilerplate code (repeat code)
 * Delegates happen when multiple inheritance
 * Ex. Following code
 *
 * 2 interface Downloader and Player which extends to FileDownloader, and FilePlayer
 * both class (FileDownloader, and FilePlayer) overrides interface method
 *
 * create 3rd class which implement both interfaces it create error to override its method
 *
 * here we use delegates at XMedia
 *
 *
 * interface Downloader             interface Player
 *          |                               |
 * class FileDownloader             class FilePlayer
 *              |                       |
 *           class XMedia (FileDownloader, FilePlayer) : Downloader by fileDownloader, Player by filePlayer  <------- use delegates
 *
 *
 *
 *Ref. simplifiedcoding
 * */

interface Downloader {
    fun download()
}

interface Player {
    fun play()
}

class FileDownloader() : Downloader{
    override fun download() {
        println("file downloading")
    }
}

class FilePlayer : Player{
    override fun play() {
        println("file playing")
    }
}

class XMedia(val fileDownloader: FileDownloader, val filePlayer: FilePlayer) : Downloader by fileDownloader,Player by filePlayer

fun main() {
    val media = XMedia(FileDownloader(),FilePlayer())
    media.download()
    media.play()
    println()
    media.fileDownloader.download()
    media.filePlayer.play()
}
_________________________________________________________________________________________________________________________________________________

Delegated properties

Lazy properties         :  the value gets computed only upon first access.
Observable properties   :  listeners get notified about changes to this property.
Storing properties in a map, :  instead of a separate field for each property.


