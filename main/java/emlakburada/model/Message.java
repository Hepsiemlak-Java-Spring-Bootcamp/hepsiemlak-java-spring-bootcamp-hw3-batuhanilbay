package emlakburada.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

	private int messageId;
	private String baslik;
	private String icerigi;
	private Date gonderilenTarih;
	private Date okunduguTarihi;
	private boolean gorulduMu;
	private User gonderici;
	private User alici;

	public Message(String baslik) {
		super();
		this.baslik = baslik;
	}

}
