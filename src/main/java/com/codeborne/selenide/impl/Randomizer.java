package com.codeborne.selenide.impl;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import java.util.UUID;
import java.util.regex.Pattern;

import static java.lang.Thread.currentThread;
import static java.lang.management.ManagementFactory.getRuntimeMXBean;

public class Randomizer {
  private static final Pattern REGEX_MXBEAN_NAME = Pattern.compile("(.*)@.*");

  @CheckReturnValue
  @Nonnull
  public String text() {
    return UUID.randomUUID().toString();
  }

  /**
   * @return a "random" file name starting with current time. It's probably
   */
  @CheckReturnValue
  @Nonnull
  public String fileName() {
    return String.format("%s_%s_%s", System.currentTimeMillis(), pid(), currentThread().getId());
  }

  @CheckReturnValue
  @Nonnull
  private String pid() {
    return REGEX_MXBEAN_NAME.matcher(getRuntimeMXBean().getName()).replaceFirst("$1");
  }
}
