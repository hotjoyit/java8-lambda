package patterns.builder;

import java.util.function.Consumer;

public class FluentMailer {
  private String from;
  private String to;
  private String subject;
  private String message;

  private FluentMailer() {}

  public FluentMailer from(final String address) {
    this.from = address;
    return this;
  }

  public FluentMailer to(final String address) {
    this.to = address;
    return this;
  }

  public FluentMailer subject(final String line) {
    this.subject = line;
    return this;
  }

  public FluentMailer body(final String message) {
    this.message = message;
    return this;
  }

  public static String send(Consumer<FluentMailer> block) {
    FluentMailer fluentMailer = new FluentMailer();
    block.accept(fluentMailer);
    return fluentMailer.toString();
  }

  @Override
  public String toString() {
    return "FluentMailer{" + "from='" + from + '\'' + ", to='" + to + '\'' + ", subject='" + subject + '\''
        + ", message='" + message + '\'' + '}';
  }
}
