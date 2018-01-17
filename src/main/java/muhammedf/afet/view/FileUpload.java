package muhammedf.afet.view;

import muhammedf.afet.util.IOUtil;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import java.util.Optional;

public class FileUpload {

    public static final String FILE_SYSTEM_RELATIVE_URI = "/var/storage";
    public static final String URL_RELATIVE_URI = "/storage";

    private UploadedFile uploadedFile;

    private Optional<FileUploadCallbackListener> callbackListener;

    public void setCallbackListener(FileUploadCallbackListener callbackListener) {
        this.callbackListener = Optional.ofNullable(callbackListener);
    }

    public void fileUploadListener(FileUploadEvent event){
        saveFile(event.getFile().getContents(), event.getFile().getFileName());
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    private void saveFile(byte[] bytes, String fileName){
        if(IOUtil.createFile(bytes, FILE_SYSTEM_RELATIVE_URI + "/" + fileName)){
            callbackListener.ifPresent(c->c.fileUploaded(fileName));
        }
    }
}
