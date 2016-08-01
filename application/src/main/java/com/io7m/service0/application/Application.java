/*
 * Copyright © 2016 <code@io7m.com> http://io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.io7m.service0.application;

import com.io7m.service0.api.SpeakerType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

@Component(immediate = true)
public final class Application
{
  private SpeakerType speaker;

  public Application()
  {

  }

  @Activate
  protected void onActivate()
  {
    System.out.println("Starting application");
  }

  @Reference(
    name = "com.io7m.service0.application",
    service = SpeakerType.class,
    cardinality = ReferenceCardinality.MANDATORY,
    policy = ReferencePolicy.STATIC,
    unbind = "unsetSpeaker")
  protected void setSpeaker(final SpeakerType s)
  {
    this.speaker = s;
  }

  protected void unsetSpeaker(final SpeakerType s)
  {
    this.speaker = null;
  }
}
