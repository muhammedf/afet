package muhammedf.afet.view;

import muhammedf.afet.dao.AfetDAO;
import muhammedf.afet.model.Afet;
import muhammedf.afet.util.FacesUtil;
import muhammedf.afet.util.IOUtil;
import muhammedf.afet.util.Navigation;

import javax.annotation.PostConstruct;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.UUID;

@Named
@ViewScoped
public class EditEntity implements Serializable, FileUploadCallbackListener {

    @Inject
    private AfetDAO afetDao;

    private FileUpload fileUpload;

    private Afet afet;

    @Inject
    private Navigation navigation;

    @PostConstruct
    public void init() {

        initOldAfet();
        if (afet == null) {
            initNewAfet();
        }

        fileUpload = new FileUpload();
        fileUpload.setCallbackListener(this);
    }

    public Afet getAfet() {
        return afet;
    }

    public void setAfet(Afet afet) {
        this.afet = afet;
    }

    private void initNewAfet() {
        String randomUUID = UUID.randomUUID().toString();
        afet = new Afet();
        afet.setSeriNo(randomUUID);
        afet.setGlideNo(randomUUID);
    }

    private void initOldAfet() {
        String idP = FacesUtil.getParameter("id");
        Long id = null;
        if (idP == null) return;
        id = Long.parseLong(idP);
        if (id == null) return;
        afet = afetDao.read(id);
    }

    public String saveEntity() {
        if (afet.getId() == null) {
            afetDao.create(afet);
            return navigation.editAfet(afet.getId());
        } else {
            afetDao.update(afet);
            return null;
        }
    }

    private void resetValues(String... s) {
        Arrays.stream(s).forEach(v -> {
            switch (v) {
                case "ilce":
                    afet.setIlce(null);
                    break;
                case "koy":
                    afet.setKoy(null);
                    break;
                case "mahalle":
                    afet.setMahalle(null);
                    break;
            }
        });
    }

    public void onIlChange(AjaxBehaviorEvent event) {
        resetValues("ilce", "koy", "mahalle");
    }

    public void onIlceChange(AjaxBehaviorEvent event) {
        resetValues("koy", "mahalle");
    }

    public void onKoyChange(AjaxBehaviorEvent event) {
        resetValues("mahalle");
    }

    @Override
    public void fileUploaded(String fileName) {
        afet.newFile(fileName);
    }

    public FileUpload getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(FileUpload fileUpload) {
        this.fileUpload = fileUpload;
    }

    public String getFilePath(String fileName){
        return IOUtil.URL_RELATIVE_URI+"/"+fileName;
    }

    public String getFileUrl(String fileName){
        System.out.println();
        return IOUtil.SERVER_URL + IOUtil.URL_RELATIVE_URI + "/" + fileName;
    }

    public void deleteFile(String fileName){
        IOUtil.deleteFile(IOUtil.FILE_SYSTEM_RELATIVE_URI+"/"+fileName);
        afet.removeFile(fileName);
    }
}
