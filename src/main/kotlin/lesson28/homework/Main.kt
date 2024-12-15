package com.pavel.likholap.lesson28.homework

import java.io.File

fun main() {

//Задача 1: Создайте текстовый файл workspace/task1/example.txt
//запишите в него строку "Hello, Kotlin!", а затем проверьте, существует ли файл.

    val file1 = File("workspace/task1/example.txt")
        .apply {
            parentFile.mkdirs()
            createNewFile()
            writeText("Hello, Kotlin!")
            println(exists())
        }

//Задача 2: Создайте директорию workspace/task2/testDir
//проверьте, является ли она директорией, и выведите её абсолютный путь.

    val dir1 = File("workspace/task2/testDir")
        .apply {
            mkdirs()
            println(isDirectory)
            println(absolutePath)
        }

//Задача 3: Создайте директорию workspace/task3/structure.
//Внутри директории structure создайте папку myDir с двумя вложенными поддиректориями subDir1 и subDir1.
//Проверьте, что myDir действительно содержит эти поддиректории.
    val dir2 = File("workspace/task3/structure")
    dir2.mkdirs()
    val dir3 = File("workspace/task3/structure/myDir")
    dir3.mkdirs()
    val folders = listOf("subDir1", "subDir2")
    folders.forEach {dir3.resolve(it).mkdirs()}
    println(dir3.listFiles().all{ folders.contains(it.name.split(File.separator).last()) })

//Задача 4: Создайте директорию workspace/task4/temp.
//Внутри директории temp создайте несколько вложенных файлов и директорий.
//Удалите директорию workspace/task4 со всем содержимым
    val dir4 = File("workspace/task4/temp")
    dir4.mkdirs()
    val file2 = File(dir4.path, "aaa.txt")
    file2.createNewFile()
    val dir5 = File(dir4.path, "sub")
    dir5.mkdirs()
    File("workspace/task4").deleteRecursively()


//Задача 5: Создайте файл workspace/task5/config/config.txt
//запишите в него список параметров (в формате ключ=значение), а затем прочитайте файл и выведите только значения.
    val file3 = File("workspace/task5/config/config.txt")
    file3.parentFile.mkdirs()
    file3.createNewFile()
    file3.writeText("key1=value1\nkey2=value2")
    file3.forEachLine { println(it.split("=").last()) }


//Задача 6: Пройди по всем вложенным директориям workspace и выведи в консоль сначала пути директорий, а потом пути файлов
    val file4 = File("workspace")
    val itemsMap = file4.walk().groupBy { it.isFile}
    println(itemsMap[false])
    println(itemsMap[true])



//Задача 7:Создайте директорию workspace/task9/docs.
//Проверь, есть ли файл с именем readme.md. Если файла нет, создайте его и запишите текст "This is a README file."
    val dir7 = File("workspace/task9/docs")
    dir7.mkdirs()
    val readme = File(dir7.path,"readme.md")
    if (!readme.exists()) readme.createNewFile()
    readme.writeText("This is a README file.")


//Задача 8
//Создайте файлы
//workspace/task10/data/1/4/prod/data14.mysql
//workspace/task10/data/2/3/prod/data23.mysql
//workspace/task10/data/5/2/prod/data52.mysql
//Создайте директорию workspace/task10/backup и скопируйте туда
//файлы из workspace/task10/data сохраняя структуру директорий. Для копирования используй метод copyTo

    val f = File("workspace/task10/data/1/4/prod/data14.mysql")
    val f1 = File("workspace/task10/data/2/3/prod/data23.mysql")
    val f2 = File("workspace/task10/data/5/2/prod/data52.mysql")

    listOf(f, f1, f2).forEach {
        if (!it.parentFile.exists()) it.parentFile.mkdirs()
        it.createNewFile()
        val target = File("workspace/task10/backup", it.relativeTo(File("workspace/task10/data")).path)
        it.copyTo(target)

    }

    val a = EncryptionManager(FileProcessorImpl(), EncryptorImpl())
    a.encryptFilesInDirectory(File("fol1"), File("backup"), "txt")

}

//Задача "Шифровальщик"

interface Encryptor {
    fun encrypt(content: String): String
}


interface FileProcessor {
    fun findFilesByExtension(extension: String, directory: File): List<File>
    fun encryptFiles(files: List<File>, encryptor: Encryptor)
    fun moveToBackup(files: List<File>, backupDir: File)

}

class FileProcessorImpl : FileProcessor {
    override fun findFilesByExtension(extension: String, directory: File): List<File> {
        return directory.walk()
            .filter { it.isFile && it.name.endsWith(".$extension") }
            .toList()
    }

    override fun encryptFiles(files: List<File>, encryptor: Encryptor) {

        files.forEach {
            val newName = "${it.name}Corrupted"
            val corrFile = File(it.parent, newName)
            corrFile.createNewFile()
            corrFile.writeText(it.readText())
            corrFile.writeText(encryptor.encrypt(corrFile.readText()))
        }

    }

    override fun moveToBackup(files: List<File>, backupDir: File) {

        backupDir.mkdirs()
        files.forEach {
            val root = File(it.path.split(File.separator).first())
            val target = File(backupDir, it.relativeTo(root).path)
            if (!target.parentFile.exists()) {
                target.parentFile.mkdirs()
            }
            it.renameTo(target)
        }

    }

}

class EncryptorImpl : Encryptor {
    override fun encrypt(content: String): String {
        return content.map { (it.code + 2).toChar() }.joinToString("")
    }
}


class EncryptionManager(private val processor: FileProcessor, private val encryptor: Encryptor){
    fun encryptFilesInDirectory(directory: File, backupDir: File, extension: String){
        val neededFiles = processor.findFilesByExtension(extension, directory)
        processor.encryptFiles(neededFiles, encryptor)
        processor.moveToBackup(neededFiles, backupDir)
    }
}