package com.chf.example.apache.zest.composite;

import org.qi4j.api.composite.TransientComposite;
import org.qi4j.api.concern.Concerns;
import org.qi4j.api.mixin.Mixins;
import org.qi4j.api.sideeffect.SideEffects;

@Mixins({ SayHelloMixin.class, GenericPropertyMixin.class })
@Concerns(SpeakerConcern.class)
@SideEffects(SpeakerSideEffect.class)
public interface SpeakerComposite extends Speaker, MyProperty,
        TransientComposite {

}
