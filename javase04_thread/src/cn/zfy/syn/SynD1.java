package cn.zfy.syn;

/**
 * һ����������ͬ����Դ��
 *������������ �źŵ�ģʽ
 *1- wait()���ȴ����ͷ�����sleep(),�ȴ������ͷ�����
 *2- notify()/notifyAll()�����ѣ�
 *3-synchronized()
 *ͬһ������ļ���Ҫ��������Ҫ���ѣ������ʵ��ͬ������������������Ѳ����������
 *��ͬ��Դmovie������m.play(pic)����m.watch(pic)��
 *��Դ���ͻ����˵��Դ��������������������
 *�Ƕ�ͬһ����Դmovie����ִ�У��������߳�watcher��player��Ҫִ���߳�������ķ���ʱ��
 *�ͻ��ͬһ����Դmovie����������watcher���߳�����õ���movie.watch()��
 *player���߳����е��õ���movie.play()������
 * �����������Ҫ����ͬһ������movieʱ����ʱ�����̷ֱ߳�ִ�ж���movie�е�����������
 *������������������synchronized���εģ���Ҫ�ȴ��ͷ������ſ��Խ��к������ 
 *4.��ʱ��ҪЭ����Դ���߳�֮��Э��������
 *����ͬ����
 *�����̵߳��߼��������ǵ�����������Э����
 * @author DELL
 *
 */
public class SynD1 {
	public static void main(String[] args) {
		Movie m=new Movie();
		
		Player p=new Player(m);
		Watcher w=new Watcher(m);
		new Thread(p).start();
		new Thread(w).start();
	}

}





/**
 *һ����������ͬ����Դ��
 *������������ �źŵ�ģʽ
 *1- wait()���ȴ����ͷ�����sleep(),�ȴ������ͷ�����
 *2- notify()/notifyAll()�����ѣ�
 *3-synchronized����
 *	��ͬ��Դmovie������m.play(pic)����m.watch(pic)��
	��Դ���ͻ����˵��Դ��������������������
 * @author DELL
 *
 */
/*class Movie {
	private String pic;
	
	//�źŵ�
	//flag-->T,�����������������ߵȴ���������ɺ�flagΪF��֪ͨ���ѣ�palyer��ʼ������
	//flag-->F�����������ѣ������ߵȴ���������ɺ�֪ͨ������watcher��ʼ���ѣ�
	private boolean flag=true;
	

	public synchronized void play(String pic) {//������
		if(!flag) {//�����ߵȴ���
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//��ʼ������
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//������ϣ�
		this.pic=pic;
		System.out.println("������--->"+pic);
		//֪ͨ���ѣ�
		this.notify();
		//������ͣ�£�
		this.flag=false;
		}
	
	public synchronized void watch() {//������
		if(flag) {//�����ߵȴ���
			try {
				this.wait();;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//������������
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("������--->"+pic);
		//������ϣ�
		//֪ͨ������
		this.notifyAll();
		//����ֹͣ��
		this.flag=true;
	}
}*/



class Movie {
	private String pic;
	//�źŵ�
	//flag-->T,�����������������ߵȴ���������ɺ�flagΪF��֪ͨ���ѣ�palyer��ʼ������
	//flag-->F�����������ѣ������ߵȴ���������ɺ�֪ͨ������watcher��ʼ���ѣ�
	private boolean flag=true;
	public synchronized void play(String pic) {//������
		//��ʼ������
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//������ϣ�
		this.pic=pic;
		System.out.println("������--->"+pic);
		//֪ͨ���ѣ�
		//������ͣ�£�
		}
	public synchronized void watch() {//������
		//������������
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("������--->"+pic);
		//������ϣ�
		//֪ͨ������
		//����ֹͣ��
	}
}



class Player implements Runnable {
	private Movie m;
	
	public Player(Movie m) {
		super();
		this.m = m;
	}
	@Override
	public void run() {
		
		for(int i=0;i<=10;i++) {
			if(0==i%2) {
				m.play("zfy");
			}else {
				m.play("lt");
			}
		}
	}
}

class Watcher implements Runnable {
	private Movie m;
	public Watcher(Movie m) {
		super();
		this.m = m;
	}
	
	@Override
	public void run() {
		for(int i=0;i<=10;i++) {
			m.watch();
		}
		
	}
}

