
import 'dart:io';

void main(List<String> args){

  var fileName = args[1]; //'Q3079';
  var path = '${args[0]}/$fileName.java'; //'D:/Projects/code_chef_submissions/src/quera/Q3079.java';

  File file = File(path);

  Directory(fileName).createSync();

  File newFile = file.copySync('${Directory.current.path}/$fileName/Q10369.java');

  var text = newFile.readAsStringSync();

  var end = text.indexOf('import');
  if(end==-1){
    end = text.indexOf('public');
  }

  text = text.replaceFirst('${fileName}', 'Q10369');

  newFile.writeAsStringSync(text.substring(end));
}
