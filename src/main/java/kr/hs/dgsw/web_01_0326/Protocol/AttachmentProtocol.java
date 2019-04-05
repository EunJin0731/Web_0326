package kr.hs.dgsw.web_01_0326.Protocol;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AttachmentProtocol {
    private String storedPath;
    private String originaName;


    public AttachmentProtocol(String storedPath, String originaName) {
        this.storedPath = storedPath;
        this.originaName = originaName;
    }
}
