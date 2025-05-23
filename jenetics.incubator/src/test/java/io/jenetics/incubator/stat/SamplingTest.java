/*
 * Java Genetic Algorithm Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmail.com)
 */
package io.jenetics.incubator.stat;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.DoubleSummaryStatistics;
import java.util.stream.IntStream;

import org.testng.annotations.Test;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 */
public class SamplingTest {

	@Test
	public void repeat() {
		final var sampling = Sampling.repeat(100, samples ->
			samples.addAll(IntStream.range(0, 100).boxed())
		);

		final var statistics = new DoubleSummaryStatistics();
		sampling.run(statistics::accept);

		assertThat(statistics.getCount()).isEqualTo(100*100);
		assertThat(statistics.getMin()).isEqualTo(0);
		assertThat(statistics.getMax()).isEqualTo(99);
	}

}
